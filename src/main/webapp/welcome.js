function createXHR() {
	if (typeof XMLHttpRequest === 'undefined') {
		XMLHttpRequest = function() {
			try {
				return new ActiveXObject("Msxml2.XMLHTTP.6.0");
			} catch (e) {
			}
			try {
				return new ActiveXObject("Msxml2.XMLHTTP.3.0");
			} catch (e) {
			}
			try {
				return new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
			}
			try {
				return new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
			}
			throw new Error("This browser does not support XMLHttpRequest.");
		};
	}
	return new XMLHttpRequest();
}

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
}

function createPaginagion() {
	var pagin = document.createElement("div");
	pagin.className = 'pagination';
	pagin.innerHTML = 'Result 1-12 of 44 <button class="button-number">1</button> <a>2</a> <a>3</a> <a>4</a> <button class="button-next">Next</button>';
	return pagin;
}

function doCompletion() {
	req = createXHR();
	req.onreadystatechange = handlerRequest;
	req.open("post", "First", true);
	req.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	req.send("action=act&name1=value1&name2=value2");
}

function handlerRequest() {
	if (req.readyState == 4 && req.status == 200) {
		var ms = JSON.parse(req.responseText);
		// alert("status:" + req.status + " | " + ms[0].user.email);
		/*
		 * txt = "<table border='1'><tr><th>Foto</th><th>User</th><th>Message</th><th>Date</th></tr>";
		 * var mes = createMessage(ms[0]); for ( var i = 0; i < ms.length; i++) {
		 * var img = "<img src='" + ms[i].user.urlFoto + "' class='pull-left
		 * img-posted'/>"; txt = txt + "<tr><td>" + img + "</td>"; txt =
		 * txt + "<tr><td>" + ms[i].user.email + "</td>"; txt = txt + "<td>" +
		 * ms[i].text + "</td>"; txt = txt + "<td>" + ms[i].date + "</td>";
		 * txt = txt + "</tr>"; } txt = txt + "</table>";
		 * document.getElementById('result').innerHTML = txt;
		 */
		for ( var i = 0; i < ms.length; i++) {
			document.getElementById('rightcolumn').appendChild(
					createMessage(ms[i]));
		}
		document.getElementById('rightcolumn').appendChild(
				createPaginagion());
		

	}
}

doCompletion();
