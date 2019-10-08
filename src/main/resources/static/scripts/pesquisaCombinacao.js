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

function populaFamilia(marketplace) {
	
	alert("Entrou na function!");
	console.log($(marketplace).val());
	
	var categoriaTabela = marketplace.closest("#selectcategoriamkp");
    
	//var marketplace = $(categoriaTabela).find('.selectmarketplace');
    
    alert("Valor: "+ $(marketplace).val());
    //var familia = $(linhaTabela).find('.familia');
    //var grupo = $(linhaTabela).find('.grupo');
    //var produto = $(linhaTabela).find('.produto');
    $.ajax({
        url: "/marketplacelinha",
        data: {idMarketplace: $(marketplace).val()},
        dataType: 'JSON',
        beforeSend: function () {
            $(marketplace).attr("disabled", "true");
            //$(familia).attr("disabled", "true");
            //$(grupo).attr("disabled", "true");
            //$(produto).attr("disabled", "true");
            //$(familia).html("<option value=''>Selecione</option>");
            //$(grupo).html("<option value=''>Selecione</option>");
            //$(produto).html("<option value=''>Selecione</option>");
        }
    }).done(function (data) {
        if (data) {
            data.forEach(function (obj) {
                $(familia).append("<option value=" + obj.codigo + ">" + obj.descricao + "</option>");
            	alert("Teste: "+obj.nome);
            });
            //$(familia).removeAttr("disabled");
        } else {
            alert("Erro ao buscar categoria!");
        }
    }).fail(function () {
        alert("Erro ao buscar categoria.");
    }).always(function () {
        $(marketplace).removeAttr("disabled");
    });
}
