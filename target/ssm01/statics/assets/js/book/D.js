function D(data) {
    var books = data.books;
    var html = "";
    for (var i = 0; i < books.length; i++) {    //遍历data数组
        html += '<tr>';
        var ls = books[i];
        html += "<td>" + ls.id + "</td>";
        html += "<td>" + ls.bookCode + "</td>";
        html += "<td>" + ls.bookName + "</td>";
        html += "<td>" + ls.bookCategory + "</td>";
        html += "<td>" + ls.bookNumber+"</td>";
        html += "<td>" + ls.bookDate + "</td>";
        html += "<td>" + (ls.bookPrice).toFixed(2)+ "元</td>";
        html += "<td>";
        html += " <a id='bookEdit' href = 'JavaScript:void(0)' onclick = 'bookCheck(" + ls.id + ");openEditDialog()'><i class='ti-pencil'></i></a>";
        html += " <a id='bookDelete' href='"+path+"/book/recycle?id="+ls.id+"' ><i class='ti-close'></i></a>";
        html += "</td>";
        html += "</tr>";
    }
    $("#list").html(html);
}