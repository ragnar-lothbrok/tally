var dom;

function getElementAmpersand() {
	var value = document.getElementById('input-1').value;
	if (value.length != 0)
		convertAmpersands(value);
}

function convertAmpersands(value) {
	while (value.indexOf("&") != -1) {
		value = value.replace("&", " and ");
	}
	document.getElementById('input-2').value = value;
}

window.addEventListener("load", getElementAmpersand, false);