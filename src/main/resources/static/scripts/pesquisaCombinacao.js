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
    	alert("Entrou no change!");
    	populaFamilia(linha)
    });
});

function populaLinhaMarketplace(marketplace) {
	
	alert("Entrou na function!");

    $.ajax({
        url: "/marketplacelinha",
        data: {idMarketplace: $(marketplace).val()},
        dataType: 'JSON',
        beforeSend: function () {
            $(marketplace).attr("disabled", "true");
        }
    }).done(function (data) {
    	
        if (data) {
        
            data.forEach(function (obj) {
            	$("#categoriamarketplaceselect").append("<option value=" + obj.idCategoria + ">" + obj.nome + "</option>");
            });

        	$('#categoriamarketplaceselect').selectpicker('refresh'); 

        } else {
            alert("Erro ao buscar categoria!");
        }
    }).fail(function () {
        alert("Erro ao buscar categoria.");
    }).always(function () {
        $(marketplace).removeAttr("disabled");
    });
}
