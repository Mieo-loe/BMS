function D(data) {
    var customer = data.customers;
    var html = "";
    for (var i = 0; i < customer.length; i++) {    //遍历data数组
        html += '<tr>';
        var ls = customer[i];
        html += "<td>" + ls.id + "</td>";
        html += "<td>" + ls.customerCode + "</td>";
        html += "<td>" + ls.customerName + "</td>";
        html += "<td>" + ls.customerPhone + "</td>";
        html += "<td>" + ls.staId + "</td>";
        html+="<td>";
        html+=" <a href = 'JavaScript:void(0)' onclick = 'customerCheck("+ls.id+");openEditDialog()'><i class='ti-pencil'></i></a>";
        html+="<a  href='"+path+"/customer/recycle?id="+ls.id+"'><i class='ti-close'></i></a>";
        html+="</td>";
        html += "</tr>";
    }
    $("#list").html(html);
}