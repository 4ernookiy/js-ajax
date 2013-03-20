function createXHR() {
	if (XMLHttpRequest) {
		// return standards XHR object
		return new XMLHttpRequest();
	}
	// return IE XHR object
	return new ActiveXObject("Microsoft.XMLHTTP");
};

var ajax = function(opts) {
	opts = {
		type : opts.type || "POST", // default method
		url : opts.url || "First", // default name controller
		onSuccess : opts.onSuccess || function() {
		},
		data : opts.data || "json", // default type return data
		params : opts.params || "" // additional parameters for query
	};
	var xhr = createXHR();
	xhr.open(opts.type, opts.url, true);
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			debugger;
			if (opts.data === 'json') {
				opts.onSuccess(xhr.responseText);
			} else if (opts.data === 'xml') {
				opts.onSuccess(xhr.responseXML);
			}
		}
	};
	xhr.setRequestHeader("Content-Type",
			"application/x-www-form-urlencoded; charset=UTF-8");
	xhr.send(opts.params);
};

function createMessage(message) {
	if (message == null)
		return;
	// container
	// var element = document.getElementById('class_ex');
	// element.className = 'classGreen';
	var c = document.createElement("div");
	c.className = 'message';
	var table = document.createElement("table");
	table.className = 't2m';
	var row = document.createElement("tr");
	var colUser = document.createElement("td");
	colUser.className = 't2m-name';
	var colMes = document.createElement("td");
	colMes.className = 't2m-message';
	var colData = document.createElement("td");
	colData.className = 't2m-date';
	var image = document.createElement('img');
	image.className = 'pull-left img-posted';
	image.src = message.user.urlFoto;
	var userName = document.createElement("span");
	userName.className = 'name-posted';
	colUser.appendChild(image);
	colUser.appendChild(userName);
	colUser.appendChild(document.createTextNode(message.user.email));
	colMes.innerHTML = message.text;
	colData.appendChild(document.createTextNode(message.date));
	row.appendChild(colUser);
	row.appendChild(colMes);
	row.appendChild(colData);
	table.appendChild(row);
	c.appendChild(table);
	return c;
};

function createPaginagion() {
	var pagin = document.createElement("div");
	pagin.className = 'pagination';
	pagin.innerHTML = 'Result 1-12 of 44 <button class="button-number">1</button> <a>2</a> <a>3</a> <a>4</a> <button class="button-next">Next</button>';
	return pagin;
};

function showMessage(messagesJson) {
	debugger;
	var ms = JSON.parse(messagesJson);
	for ( var i = 0; i <= 5; i++) {
		document.getElementById('rightcolumn')
				.appendChild(createMessage(ms[i]));
	}
	document.getElementById('rightcolumn').appendChild(createPaginagion());
};

/*
 * ajax({ onSuccess: showMessage, params: "action=getList" });
 */

function ViewPage() {
	this.countPerPage = 5; // в дальнейшем будет передаваться через аякс для указания количества сообщений на странице
	this.messages = [];
	this.page;

	this.update = function (messagesJson) {
		debugger;
		var ms = JSON.parse(messagesJson);
		this.messages[this.page] = ms;
		this.show(this.page);
		debugger;
	};

	this.show = function(page) { // page потом будет использоваться в парамметрах ajax
		this.page = page;
		if (this.messages[page] == null) {  // на этом месте потом вставлю хранилище... когда хоть это заработает
			debugger;
			ajax({ onSuccess: this.update, params: "action=getList&page=" + page });
			alert(" waiting query!");
			return;
		}
		debugger;
		var ms = this.messages[page];
		if (ms === null) {
			alert("OOoo! all broken");
			return;
		}
		
		for ( var i = 0; i <= countPerPage; i++) {
			document.getElementById('rightcolumn').appendChild(
					createMessage(ms[i]));
		}
		document.getElementById('rightcolumn').appendChild(createPaginagion());
	};
	
};

var page = new ViewPage();
page.show(1);
