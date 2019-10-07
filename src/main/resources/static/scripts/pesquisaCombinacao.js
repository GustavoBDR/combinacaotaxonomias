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
    
    $('#selectmarketplace').change(function(){
    	let valor = $(this).val();
    	alert("O valor é: "+valor);
    })
});

