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


function doCompletion() {
	req = createXHR();
	req.onreadystatechange = function() {
		if (req.readyState == 4 && req.status == 200) {
			var ms = JSON.parse(req.responseText);
			//alert("status:" + req.status + " | " + ms[0].user.email);
			txt = "<table border='1'><tr><th>User</th><th>Message</th><th>Date</th></tr>";
			for (var i=0; i < ms.length; i++) {
				txt = txt + "<tr><td>" + ms[i].user.email+"</td>";
				txt = txt + "<td>" + ms[i].text+"</td>";
				txt = txt + "<td>" + ms[i].date+"</td>";
				txt = txt + "</tr>";
			}
			txt = txt + "</table>";
			document.getElementById('result').innerHTML = txt;
		}
	};

	req.open("post", "First", true);
	req.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	req.send("action=act&name1=value1&name2=value2");
};

function updatePage() {
	if (req.readyState == 4) {
		alert(req.responseText);
	} else {
		alert("status=" + req.readyState);
	}
}

doCompletion();