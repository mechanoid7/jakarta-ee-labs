const EDITABLE_COOKIE = "editable"

function setEditableCookie(editable = false) {
    document.cookie = EDITABLE_COOKIE + "=" + editable
}

function getCookieByName(name) {
    const value = "; " + document.cookie;
    const parts = value.split("; " + name + "=");
    if (parts.length === 2) {
        return parts.pop().split(";").shift();
    }
}
