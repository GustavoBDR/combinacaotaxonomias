$(document).ready(function () {
    $("#btnCadastrar").click(function(){
        location.href="/cadastromarketplace";
    });
    $("#bntCancelarBusca").click(function(){
        location.href="/";
    });    
    $( "#btnSubmit" ).click(function() {
  	  $( "#formPesquisa" ).submit();
  	});    
});

