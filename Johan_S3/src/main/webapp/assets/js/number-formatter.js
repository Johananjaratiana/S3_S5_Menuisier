var allNumber = document.getElementsByClassName("simple-number");
for(let i = 0 ; i < allNumber.length ; i++){
    allNumber[i].style.textAlign = "right";
}

var allMoneyNumber = document.getElementsByClassName("money-number");
for(let i = 0 ; i < allMoneyNumber.length ; i++){
    allMoneyNumber[i].innerHTML = numeral(allMoneyNumber[i].innerHTML).format('0,0.[00]');
    allMoneyNumber[i].innerHTML = allMoneyNumber[i].innerHTML.replace(/,/g, " ");
    allMoneyNumber[i].style.textAlign = "right";
}