$(document).ready(function () {
    $("#btnVendedor").click(function(){
        location.href="/vendedor";
    }); 
    $("#btnMarketplace").click(function(){
        location.href="/marketplace";
    });
    $("#btnCombinacao").click(function(){
        location.href="/cadastrocombinacaocategoria";
    });     
    $("#btnPesquisaCombinacao").click(function(){
        location.href="/buscaCombinacao";
    });    
});

