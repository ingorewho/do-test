function cross(data) {
    var ajax = new XMLHttpRequest();
    var url = "http://127.0.0.1:8099/cross"
    ajax.open( "post" , url , true );
    ajax.setRequestHeader( "Content-Type" , "application/x-www-form-urlencoded" );
    ajax.send(data);
}