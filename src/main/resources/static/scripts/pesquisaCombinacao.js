$(document).ready(function () {
    $("#bntCancelaCadastro").click(function(){
        location.href="/";
    });
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
            	$("#linhaMarketplaceSelect").append("<option value=" + obj.idCategoriaPlataforma + ">" + obj.nome + "</option>");
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
	
    $.ajax({
        url: "/marketplaceCategoriaFilha",
        data: {idMarketplace: $('#idMarketplaceSelect').val(), idCategoriaPai: $(idLinhaMarketplace).val()},
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
            	$("#familiaMarketplaceSelect").append("<option value=" + obj.idCategoriaPlataforma + ">" + obj.nome + "</option>");
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
	
    $.ajax({
        url: "/marketplaceCategoriaFilha",
        data: {idMarketplace: $('#idMarketplaceSelect').val(), idCategoriaPai: $(idFamiliaMarketplace).val()},
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
            	$("#grupoMarketplaceSelect").append("<option value=" + obj.idCategoriaPlataforma + ">" + obj.nome + "</option>");
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
            	$("#linhaVendedorSelect").append("<option value=" + obj.idCategoriaPlataforma + ">" + obj.nome + "</option>");
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
	
    $.ajax({
        url: "/vendedorCategoriaFilha",
        data: {idVendedor: $('#idVendedorSelect').val(), idCategoriaPai: $(idLinhaVendedor).val()},
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
            	$("#familiaVendedorSelect").append("<option value=" + obj.idCategoriaPlataforma + ">" + obj.nome + "</option>");
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
	
    $.ajax({
        url: "/vendedorCategoriaFilha",
        data: {idVendedor: $('#idVendedorSelect').val(), idCategoriaPai: $(idFamiliaVendedor).val()},
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
            	$("#grupoVendedorSelect").append("<option value=" + obj.idCategoriaPlataforma + ">" + obj.nome + "</option>");
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
