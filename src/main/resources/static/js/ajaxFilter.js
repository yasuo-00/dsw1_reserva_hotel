$(document).ready(function() {
	$('#city').on('keyup', function() {
		var value = $(this).val();
		console.log(data);
		console.log('asdjhoadjoiadjaiosd');
		rebuildForm(data);

	})
	$('#city').keyup();;
});

function rebuildForm(data) {
	var form = document.getElementById('filter');
	form.innerHTML = '';
	form += '<form th:action="@{/hotels/city/' + data.city
			+ '}" id="filter"><input type="text" id="city" name="city" value="'+data+'>';
	form += '<input type="submit" th:value="#{filter}"> </button> </form>';

}