function D(data) {
    var cards=data.cards;
    var  html="";
    for (var i = 0; i < cards.length; i++) {    //遍历data数组
        html+='<tr>'
        var ls = cards[i];
        html += "<td>"+ls.id+"</td>";
        html += "<td>"+ls.createDate+"</td>";
        html += "<td>"+ls.expirationDate+"</td>";
        html += "<td>"+ls.discount+"</td>";
        html += "<td>"+ls.customer.customerName+"</td>";
        html += "<td>"+ls.staff.staffName+"</td>";
        html+="</tr>";
    }
    $("#list").html(html);
}