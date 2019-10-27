$(document).ready(function () {
    $("#bntCancelaCadastro").click(function(){
        location.href="/";
    });
    
    if ($('#idCombinacaoCategoria').val() > 0) {

    	var linhaMarketplace = ($("#idLinhaMarketplaceSelecionada").val());
    	var familiaMarketplace = ($("#idFamiliaMarketplaceSelecionada").val());
    	var grupoMarketplace = ($("#idGrupoMarketplaceSelecionada").val());
    	
    	var linhaVendedor = ($("#idLinhaVendedorSelecionado").val());
    	var familiaVendedor = ($("#idFamiliaVendedorSelecionado").val());
    	var grupoVendedor = ($("#idGrupoVendedorSelecionado").val());
    	
    	populaLinhaMarketplace($("#idMarketplaceSelect"));
    	setTimeout( function(){ 
          	$('#linhaMarketplaceSelect').val(linhaMarketplace);
          	$('#linhaMarketplaceSelect').selectpicker('refresh');
      	}  , 1000 );

    	populaFamiliaMarketplace(linhaMarketplace);
    	setTimeout( function(){ 
          	$('#familiaMarketplaceSelect').val(familiaMarketplace);
          	$('#familiaMarketplaceSelect').selectpicker('refresh');
      	}  , 1050 );
    	
    	populaGrupoMarketplace(familiaMarketplace);
    	setTimeout( function(){ 
          	$('#grupoMarketplaceSelect').val(grupoMarketplace);
          	$('#grupoMarketplaceSelect').selectpicker('refresh');
      	}  , 1100 );
    	
    	
    	populaLinhaVendedor($("#idVendedorSelect"));
    	setTimeout( function(){ 
          	$('#linhaVendedorSelect').val(linhaVendedor);
          	$('#linhaVendedorSelect').selectpicker('refresh');
      	}  , 1000 );
    	
    	populaFamiliaVendedor(linhaVendedor);
    	setTimeout( function(){ 
          	$('#familiaVendedorSelect').val(familiaVendedor);
          	$('#familiaVendedorSelect').selectpicker('refresh');
      	}  , 1050 );
    	
    	populaGrupoVendedor(familiaVendedor);  	
    	setTimeout( function(){ 
          	$('#grupoVendedorSelect').val(grupoVendedor);
          	$('#grupoVendedorSelect').selectpicker('refresh');
      	}  , 1100 );
      	

    }
});

function populaLinhaMarketplace(marketplace) {
	
    $.ajax({
        url: "/marketplacelinha",
        data: {idMarketplace: $(marketplace).val()},
        dataType: 'JSON',
        beforeSend: function () {

        	$('#linhaMarketplaceSelect')
    	    .find('option')
    	    .remove()
    	    .end();
        }
    }).done(function (data) {
    	
        if (data) {
        	$("#linhaMarketplaceSelect").append("<option value=0>Selecione uma opção</option>");
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

    });
}

function populaFamiliaMarketplace(idLinhaMarketplace) {
	var id;
	if ($('#idCombinacaoCategoria').val() > 0) {
		id = idLinhaMarketplace;
	}else{
		id = $(idLinhaMarketplace).val();
	}
    $.ajax({
        url: "/marketplaceCategoriaFilha",
        data: {idMarketplace: $('#idMarketplaceSelect').val(), idCategoria: id},
        dataType: 'JSON',
        beforeSend: function () {

        	$('#familiaMarketplaceSelect')
    	    .find('option')
    	    .remove()
    	    .end();
        }
    }).done(function (data) {
    	
        if (data) {
        	$("#familiaMarketplaceSelect").append("<option value=0>Selecione uma opção</option>");
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

    });
}

function populaGrupoMarketplace(idFamiliaMarketplace) {
	var id;
	if ($('#idCombinacaoCategoria').val() > 0) {
		id = idFamiliaMarketplace;
	}else{
		id = $(idFamiliaMarketplace).val();
	}

    $.ajax({
        url: "/marketplaceCategoriaFilha",
        data: {idMarketplace: $('#idMarketplaceSelect').val(), idCategoria: id},
        dataType: 'JSON',
        beforeSend: function () {

        	$('#grupoMarketplaceSelect')
    	    .find('option')
    	    .remove()
    	    .end();
        }
    }).done(function (data) {
    	
        if (data) {
        	$("#grupoMarketplaceSelect").append("<option value=0>Selecione uma opção</option>");
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

    });
}

function populaLinhaVendedor(vendedor) {
	
    $.ajax({
        url: "/vendedorlinha",
        data: {idVendedor: $(vendedor).val()},
        dataType: 'JSON',
        beforeSend: function () {

        	$('#linhaVendedorSelect')
    	    .find('option')
    	    .remove()
    	    .end();
        }
    }).done(function (data) {
    	
        if (data) {
        	$("#linhaVendedorSelect").append("<option value=0>Selecione uma opção</option>");
            data.forEach(function (obj) {
            	$("#linhaVendedorSelect").append("<option value=" + obj.idCategoria + ">" + obj.nome + "</option>");
            });

        	$('#linhaVendedorSelect').selectpicker('refresh'); 

        } else {
            alert("Erro ao buscar categoria!");
        }
    }).fail(function () {
        alert("Erro ao buscar categoria.");
    }).always(function () {

    });
    
}

function populaFamiliaVendedor(idLinhaVendedor) {
	var id;
	if ($('#idCombinacaoCategoria').val() > 0) {
		id = idLinhaVendedor;
	}else{
		id = $(idLinhaVendedor).val();
	}	

    $.ajax({
        url: "/vendedorCategoriaFilha",
        data: {idVendedor: $('#idVendedorSelect').val(), idCategoria: id},
        dataType: 'JSON',
        beforeSend: function () {

        	$('#familiaVendedorSelect')
    	    .find('option')
    	    .remove()
    	    .end();
        }
    }).done(function (data) {
    	
        if (data) {
        	$("#familiaVendedorSelect").append("<option value=0>Selecione uma opção</option>");
            data.forEach(function (obj) {
            	$("#familiaVendedorSelect").append("<option value=" + obj.idCategoria + ">" + obj.nome + "</option>");
            });

        	$('#familiaVendedorSelect').selectpicker('refresh'); 

        } else {
            alert("Erro ao buscar categoria!");
        }
    }).fail(function () {
        alert("Erro ao buscar categoria.");
    }).always(function () {

    });
}

function populaGrupoVendedor(idFamiliaVendedor) {
	
	var id;
	if ($('#idCombinacaoCategoria').val() > 0) {
		id = idFamiliaVendedor;
	}else{
		id = $(idFamiliaVendedor).val();
	}
	
    $.ajax({
        url: "/vendedorCategoriaFilha",
        data: {idVendedor: $('#idVendedorSelect').val(), idCategoria: id},
        dataType: 'JSON',
        beforeSend: function () {

        	$('#grupoVendedorSelect')
    	    .find('option')
    	    .remove()
    	    .end();
        }
    }).done(function (data) {
    	
        if (data) {
        	$("#grupoVendedorSelect").append("<option value=0>Selecione uma opção</option>");
            data.forEach(function (obj) {
            	$("#grupoVendedorSelect").append("<option value=" + obj.idCategoria + ">" + obj.nome + "</option>");
            });

        	$('#grupoVendedorSelect').selectpicker('refresh'); 

        } else {
            alert("Erro ao buscar categoria!");
        }
    }).fail(function () {
        alert("Erro ao buscar categoria.");
    }).always(function () {

    });
}
