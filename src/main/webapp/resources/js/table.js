$(document).ready(function () {
    $.post('Controller', {
        action: 'table'
    }, function (responseJson) {
        fillTable(responseJson);
    });

    $('#sortItem').change(function () {
        var $levelItem = $("select#sortItem").val();
        $.post('Controller', {
            action: 'table',
            levelItem: $levelItem
        }, function (responseJson) {
            fillTable(responseJson);
        });
    });
    $('#search_key').click(function () {
        var $criteria = $("select#criteria").val();
        var $searchword = $("#searchword").val();
        $.post('Controller', {
            action: 'table',
            criteria: $criteria,
            searchword: $searchword
        }, function (responseJson) {
            fillTable(responseJson);
        });
    });

    $('#searchword').keypress(function () {
        var $criteria = $("select#criteria").val();
        if ($criteria === 'uid') {
            if ((event.keyCode < 48) || (event.keyCode > 57))
                return false;
        } else if ($criteria === 'title' || $criteria === 'seller') {
            return true;
        }
    });

    $('#criteria').change(function () {
        $('#searchword').val("");
    });

    $("thead th").click(function () {
        var rows = $.makeArray($("#dynamic").find("tr"));
        var arrow, col_sort_num;
        var th = this;

        $("thead th").each(function (i) {
            if (th == this) {
                col_sort_num = i;
                if (this.prevsort == "y") {
                    arrow = this.firstChild;
                    th.up = Number(!th.up);
                } else {
                    this.prevsort = "y";
                    $("span").insertBefore(this.firstChild);
                    arrow = this.firstChild;
                    th.up = 0;
                }
                arrow.innerHTML = th.up ? "↑ " : "↓ ";
            } else {
                if (this.prevsort == "y") {
                    this.prevsort = "n";
                }
            }
        });

        rows.sort(function (a, b) {
            // 2 способа поиска чайлдов у ноды.
            var x = $(a).find("th").eq(col_sort_num).text();
            var y = $(b).children("th").eq(col_sort_num).text();

            if (!isNaN(Number(x)) && !isNaN(Number(y))) {
                return x - y;
            } else if (this == "Stop Date") {
                return x - y;
            } else {
                return x.localeCompare(y);
            }
        });

        if (this.up) {
            rows.reverse();
        }
        $(rows).prependTo("#dynamic");
    });
});

function onlyDigit() {
    if ((event.keyCode < 48) || (event.keyCode > 57))
        event.returnValue = false;
}

function buy(row) {
    // Тут код покупка
    var $rowIdx = $(row).parent().parent('tr');
    var $tdId = $rowIdx.children("th:nth-child(1)").html();

    $.post('Controller', {
        action: 'bidding',
        idItem: $tdId,
        buynow: true
    }, function (responseJson) {
        fillTable(responseJson);
    });
}

function deleteItem(row) {
    // Тут код ставки
    var $rowIdx = $(row).parent().parent('tr');
    var $tdId = $rowIdx.children("th:nth-child(1)").html();

    $.post('Controller', {
        action: 'delete',
        idItem: $tdId
    }, function (responseJson) {
        fillTable(responseJson);
    });
}

function bid(row) {
    // Тут код ставки
    var $rowIdx = $(row).parent().parent('tr');
    var $tdId = $rowIdx.children("th:nth-child(1)").html();
    var $tdInputBid = $rowIdx.children("th:nth-child(10)").children("input[type=text]").val();

    $.post('Controller', {
        action: 'bidding',
        idItem: $tdId,
        bid: $tdInputBid,
        buynow: false
    }, function (responseJson) {
        fillTable(responseJson);
    });
}



function fillTable(array) {
    var out = "";
    $.each(array, function (i, item) {
        var bidding;
        var buyItNow = (item.buyItNow == "true");
        var sold = (item.sold == "true");

        //noinspection JSJQueryEfficiency
        if ($("span[id=userlogin]").text() === '') {
            bidding = "Register";
        } else if ($("span[id=userlogin]").text() === item.login) {
            bidding = "<input type='button' class='bttBid' value = 'Del' onclick='deleteItem(this)'/>";
        } else {
            if (sold) {
                bidding = "It's sold";
            } else if (item.timeRest == "NaN") {
                bidding = "Time is over";
            } else {
                if (buyItNow) {
                    bidding = "<input type='button' class='bttBuy' value = 'Buy' onclick='buy(this)'/>";
                } else {
                    bidding = "<input type='text' class='bid' size='5' onkeypress='onlyDigit()'/>"
                        + "<input type='button' class='bttBid' value = 'Bid' onclick='bid(this)'/>";
                }
            }
        }

        out += "<tr><th>" + item.id +
            "</th><th>" + item.title +
            "</th><th>" + item.description +
            "</th><th>" + item.seller +
            "</th><th>" + item.startPrice +
            "</th><th>" + item.bidIncriment +
            "</th><th>" + item.bestOffer +
            "</th><th>" + item.bidderId +
            "</th><th>" + item.timeRest +
            "</th><th>" + bidding +
            "</th></tr>";
    });
    $("#dynamic").html(out);
}