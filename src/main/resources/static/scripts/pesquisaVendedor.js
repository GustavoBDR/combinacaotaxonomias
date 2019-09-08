$(document).ready(function () {
    $("#btnCadastrar").click(function(){
        location.href="/cadastrovendedor";
    });
    $("#bntCancelarBusca").click(function(){
        location.href="/";
    });    
    $( "#btnSubmit" ).click(function() {
  	  $( "#formPesquisa" ).submit();
  	});    
});

