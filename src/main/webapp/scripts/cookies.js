function getToken() {
	var token = getCookie("token");
	return "Basic "+token;
}

function saveToken(token) {
    document.cookie = "token=" + token;
}

function isTokenExists() {
	var token = getCookie("token");
	if (token == "") {
		return false;
	}
	else {
		return true;
	}
}

function getRole() {
	var role = getCookie("role");
	return role;
}

function saveRole(role) {
    document.cookie = "role=" + role;
}

function getCity() {
	var city = getCookie("city");
	return city;
}

function saveCity(city) {
    document.cookie = "city=" + city;
}

function getPhoneNumber() {
	var phoneNumber = getCookie("phoneNumber");
	return phoneNumber;
}

function savePhoneNumber(phoneNumber) {
    document.cookie = "phoneNumber=" + phoneNumber;
}

function getEmail() {
	var email = getCookie("email");
	return email;
}

function saveEmail(email) {
    document.cookie = "email=" + email;
}

function clearCookies() {
    document.cookie = "token=; expires=Thu, 01 Jan 1970 00:00:00 UTC;";
	document.cookie = "role=; expires=Thu, 01 Jan 1970 00:00:00 UTC;";
	document.cookie = "email=; expires=Thu, 01 Jan 1970 00:00:00 UTC;";
	document.cookie = "city=; expires=Thu, 01 Jan 1970 00:00:00 UTC;";
	document.cookie = "phoneNumber=; expires=Thu, 01 Jan 1970 00:00:00 UTC;";
}

function getCookie(cookieName) {
	var name = cookieName + "=";
	var decodedCookie = decodeURIComponent(document.cookie);
	var ca = decodedCookie.split(';');
	for(var i = 0; i <ca.length; i++) {
		var c = ca[i];
		while (c.charAt(0) == ' ') {
			c = c.substring(1);
		}
		if (c.indexOf(name) == 0) {
			return c.substring(name.length, c.length);
		}
	}
	return "";
}