function D(data) {
    var cashRecords=data.cashRecords;
    var  html="";
    for (var i = 0; i < cashRecords.length; i++) {    //遍历data数组
        var ls = cashRecords[i];
        html+='<tr>';
        html += "<td>"+ls.id+"</td>";
        html += "<td>"+ls.cashDate+"</td>";
        html += "<td>"+ls.carId+"</td>";
        html += "<td>"+ls.book.bookName+"</td>";
        html += "<td>"+ls.cashAmount+"</td>";
        html += "<td>"+ls.cashProfit+"</td>";
        html+="<td>";
        html += "<a href='"+path+"/cash_record/recycle?id="+ls.id+"'><i class='ti-close'></i></a>";
        html+="</td>";
        html+="</tr>";
    }
    $("#list").html(html);
}