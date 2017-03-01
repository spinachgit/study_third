<html>
<body>
	<h2>Hello World!</h2>
</body>
<script type="text/javascript">
	function temp() {
		var data = {};
		
		var obj = new Array();
		for (var i = 0; i < 5; i++) {
			var temp = {};
			temp.goodsId = 100+i;
			temp.goodsName = "面包"+i;
			temp.barcode = "1564131"+i;
			temp.costPrice = 133.23+i;
			temp.purchaseCount = 10+i;
			obj.push(temp);
		}
		var content = JSON.stringify(obj);
		console.log(content);
		
	}
</script>
</html>
