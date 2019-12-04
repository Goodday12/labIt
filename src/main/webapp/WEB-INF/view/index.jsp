<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>Hello, world!</title>
</head>
<body>
<div id="mainContainer" class="container" align="center" >
    <div class="mx-auto">
        <h1>Menu</h1>
    </div>

    <div class="input-group mb-3">
        <div class="mx-auto">
            <div class="col-sm px-md-5">
                <div class="custom-file">
                    <input type="file" class="custom-file-input" id="inputGroupFile01"
                           aria-describedby="inputGroupFileAddon01" multiple>
                    <label class="custom-file-label" for="inputGroupFile01">Choose file</label>
                </div>
            </div>
        </div>

    </div>

    <div class="btn-group-vertical mb-3" role="group" aria-label="Vertical button group">
        <button id="load" type="button" class="btn btn-secondary">Load</button>
    </div>



</div>


<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
<script>
    $('#load').click( () => {

        var data = new FormData();
        $.each($('#inputGroupFile01')[0].files, function(i, file) {
            data.append('file', file);
        });

        $.ajax({
            url: '/labIt_war_exploded/load',
            data: data,
            cache: false,
            contentType: false,
            processData: false,
            method: 'POST',
            enctype: 'multipart/form-data',
            success: function(data){
                let table = JSON.parse(data);
                //table head build
                let tableHead = "<tr>\n";
                for (let x in table.table) {
                    tableHead += "<th scope=\"col\">"+ table.table[x].name +"</th>\n";
                }
                tableHead += " </tr>\n";


                console.log(table);
                //tbody build
                let tableBody = "";
                let rows = table.table[0].cells.length;
                console.log(rows)
                for (let i = 0; i < rows; i++) {
                    tableBody += "<tr>\n";
                    for (let y in table.table){
                        tableBody += "<td>"+ table.table[y].cells[i].value +"</td>\n"
                    }
                    tableBody += "</tr>\n";
                }

                console.log(tableBody);

                $("#mainContainer").append("<div class='mx-auto mb-3'>" +
                    "<table class=\"table table-striped\">\n" +
                    "        <caption>"+ table.name +"</caption>\n" +
                    "        <thead>\n" +
                    tableHead +
                    "        </thead>\n" +
                    "        <tbody>\n" +
                        tableBody +
                    "        </tbody>\n" +
                    "    </table>" +
                    "<button onclick='f()'>Clear</button>" +
                    "</div>");
            },
            error: function (error) {
                alert("err");
            }
        });
    });

    function f(){
        console.log(this.parent);
        console.log(this);
        let divToRemove = this.parent;
        this.parent.parent.removeChild(divToRemove);
    }
</script>
</body>
</html>