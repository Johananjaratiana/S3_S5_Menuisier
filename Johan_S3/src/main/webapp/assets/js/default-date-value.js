var allDateTime = document.getElementsByClassName("currentDateTime");
for (var i = 0; i < allDateTime.length; i++) {
    var now = new Date();
    var year = now.getFullYear();
    var month = ("0" + (now.getMonth() + 1)).slice(-2); // Les mois sont indexés à partir de 0
    var day = ("0" + now.getDate()).slice(-2);
    var hour = ("0" + now.getHours()).slice(-2);
    var minute = ("0" + now.getMinutes()).slice(-2);
    var formattedDateTime = year + "-" + month + "-" + day + "T" + hour + ":" + minute;
    allDateTime[i].value = formattedDateTime;
}

var allDate = document.getElementsByClassName("currentDate");
for (var i = 0; i < allDate.length; i++) {
    var now = new Date();
    var year = now.getFullYear();
    var month = ("0" + (now.getMonth() + 1)).slice(-2); // Les mois sont indexés à partir de 0
    var day = ("0" + now.getDate()).slice(-2);
    var formattedDateTime = year + "-" + month + "-" + day;
    allDate[i].value = formattedDateTime;
}
