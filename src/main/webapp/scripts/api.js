function deleteGroup(id) {
    const xhr = new XMLHttpRequest();
    xhr.open('DELETE', '/groups?id=' + id);
    xhr.send();
    xhr.onreadystatechange = function() {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                console.log('Group removed successfully');
                location.reload();
            } else {
                console.error('Error, group not removed');
            }
        }
    }
}

function deleteStudent(id) {
    const xhr = new XMLHttpRequest();
    xhr.open('DELETE', '/students?id=' + id);
    xhr.send();
    xhr.onreadystatechange = function() {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                console.log('Student removed successfully');
                location.reload();
            } else {
                console.error('Error, student not removed');
            }
        }
    }
}