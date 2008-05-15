function main(args) {
	var hello = 'Hello World!';
	println(hello);
	
	if (!args.isEmpty()) {
		println("Args:");	
		for (var i = 0; i < args.size(); i++) {
			println(args.get(i));
		}
	}
	
	return hello;
}

function displayJSON() {
	for (var a in jsonObject) {
		println(a + '=' + eval('jsonObject.' + a));
	}
}
