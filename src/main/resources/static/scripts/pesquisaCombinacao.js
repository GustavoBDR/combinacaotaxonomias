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
	
    $.ajax({
        url: "/marketplacelinha",
        data: {idMarketplace: $(marketplace).val()},
        dataType: 'JSON',
        beforeSend: function () {
            $(marketplace).attr("disabled", "true");

        	$('#linhaMarketplaceSelect')
    	    .find('option')
    	    .remove()
    	    .end();
        }
    }).done(function (data) {
    	
        if (data) {
        
            data.forEach(function (obj) {
            	$("#linhaMarketplaceSelect").append("<option value=" + obj.idCategoria + ">" + obj.nome + "</option>");
            });

        	$('#linhaMarketplaceSelect').selectpicker('refresh'); 

        } else {
            alert("Erro ao buscar categoria!");
        }
    }).fail(function () {
        alert("Erro ao buscar categoria.");
    }).always(function () {
        $(marketplace).removeAttr("disabled");
    });
}

function populaFamiliaMarketplace(idLinhaMarketplace) {
	
    $.ajax({
        url: "/marketplaceCategoriaFilha",
        data: {idMarketplace: $('#idMarketplaceSelect').val(), idCategoriaPai: $(idLinhaMarketplace).val()},
        dataType: 'JSON',
        beforeSend: function () {
            $('#linhaMarketplaceSelect').attr("disabled", "true");

        	$('#familiaMarketplaceSelect')
    	    .find('option')
    	    .remove()
    	    .end();
        }
    }).done(function (data) {
    	
        if (data) {
        
            data.forEach(function (obj) {
            	$("#familiaMarketplaceSelect").append("<option value=" + obj.idCategoria + ">" + obj.nome + "</option>");
            });

        	$('#familiaMarketplaceSelect').selectpicker('refresh'); 

        } else {
            alert("Erro ao buscar categoria!");
        }
    }).fail(function () {
        alert("Erro ao buscar categoria.");
    }).always(function () {
        $(marketplace).removeAttr("disabled");
    });
}

function populaGrupoMarketplace(idFamiliaMarketplace) {
	
    $.ajax({
        url: "/marketplaceCategoriaFilha",
        data: {idMarketplace: $('#idMarketplaceSelect').val(), idCategoriaPai: $(idFamiliaMarketplace).val()},
        dataType: 'JSON',
        beforeSend: function () {
        	$('#linhaMarketplaceSelect').attr("disabled", "true");
        	$('#familiaMarketplaceSelect').attr("disabled", "true");

        	$('#grupoMarketplaceSelect')
    	    .find('option')
    	    .remove()
    	    .end();
        }
    }).done(function (data) {
    	
        if (data) {
        
            data.forEach(function (obj) {
            	$("#grupoMarketplaceSelect").append("<option value=" + obj.idCategoria + ">" + obj.nome + "</option>");
            });

        	$('#grupoMarketplaceSelect').selectpicker('refresh'); 

        } else {
            alert("Erro ao buscar categoria!");
        }
    }).fail(function () {
        alert("Erro ao buscar categoria.");
    }).always(function () {
        $(marketplace).removeAttr("disabled");
    });
}