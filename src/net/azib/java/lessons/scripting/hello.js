function printList() {
	var arr = megaList.toArray()
	for (var s in arr) {
		print(arr[s])
	}
	megaList.add("JSKoer")
}

function calculateStuff(a, b) {
  return a * b - a;
}