$(document).ready(function() {

		$('#cityFilter').on('keyup', function() {
			var city = $(this).val();
			$.ajax({
				type : 'GET',
				url : 'http://localhost:8080/cidades/filtros?term='+ city,
				success : function(result) {
					var s = '';
					
					s += '<table id="hotelTable" class="table table-striped table-hover table-sm">';
					s +='<thead>';
					s +='<tr>';
					s +='<th>#</th>';
					s +='<th th:text="#{name}"></th>';
					s +='<th th:text="#{cnpj}"></th>';
					s +='<th th:text="#{city}"></th>';
					s +='<th th:text="#{phone}"></th>';
					s +='<th th:text="#{hotel_dailyRate}"></th>';
					s +='<div sec:authorize="isAuthenticated()" style="right: 10px; position: absolute">';
					s +='<th th:text="#{action}"></th>';
					s +='</div>';
					s +='</tr>';
					s +='</thead>';
					s +='<tbody>';
					for (var i = 0; i < result.length; i++) {
						var hotel = result[i];
						s +='<tr>'
						s += '<td>'+hotel.id+'</td>';
						s +='<td>'+hotel.name+'</td>';
						s +='<td'+hotel.cnpj+'></td>';
						s +='<td'+hotel.city+'></td>';
						s +='<td'+hotel.dailyRate+'></td>';
						s +='<td'+encodeURI(th:text="|R$ ${#numbers.formatDecimal('+hotel.dailyRate+',2,2,'COMMA')}|")+'></td>';
						s +=<div sec:authorize="hasRole('ROLE_ADMIN')" style="right: 10px; position: absolute">
						s +=<td colspan="2"><a class="btn btn-info btn-sm" th:href="@{/hotels/edit/{id} (id=${hotel.id}) }" role="button">
						s +=<span class="oi oi-brush" th:title="#{edit}" aria-hidden="true"></span>
						s +=</a>
						s +=<button	th:id="${#strings.concat('btn_hotels/remove/',hotel.id)}" type="button" class="btn btn-danger btn-sm" data-toggle="modal" data-target="#myModal">
						s +=<span class="oi oi-circle-x" th:title="#{remove}" aria-hidden="true"></span>
						s +=</button></td>
						s +=</div>
						s +='</tr>'
					}					
					s += '</table>';
					s += '<br/>';
					s += '<a href="/">Voltar</a>';
					$('#cidades').html(s);
				},
				error: function (request, status, error) {
				       alert(request.responseText);
				}
			});
		})
		
		$('#nome').keyup();
	});