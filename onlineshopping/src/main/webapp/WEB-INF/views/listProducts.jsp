<div class="container">


	<div class="row">

		<!-- would be to display sidebar -->

		<div class="col-md-3">
			<%@ include file="./shared/sidebar.jsp"%>
		</div>


		<!-- would be to display actual products -->

		<div class="col-md-9">
		<!-- added breadcrump componenet -->
			<div class="row">

				<div class="col-lg-12">
                      
                      
                      <c:if test="${userClickAllProducts==true}">
                      
                      <script >
                      window.categoryId='' ;
                      </script>

					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
						<li class="breadcrumb-item active">All Products</li>
					</ol>
                    </c:if>
                    
                    
                    
                     <c:if test="${userClickCategoryProducts==true}">
                     
                      <script >
                      window.categoryId='${category.id}' ;
                      </script>

					<ol class="breadcrumb">
						<li class="breadcrumb-item"><a href="${contextRoot}/home">Home</a></li>
						<li class="breadcrumb-item">Category</li>
						<li class="breadcrumb-item">${category.name}</li>
					</ol>
                    </c:if>
                    
                    
                    
                    
				</div>


			</div>

         <!-- datatables -->
         	
         <div class="row">    
         <div class="col-xs-12 ">
         
         <table id="productListTable" class="table table-striped table-borderd">
         
         <thead>
         <tr>
        <th></th>
         <th>NAME</th>
         <th>BRAND</th>
         <th>PRICE</th>
         <th>Qte.Available</th>
         <th></th>
         
         </tr>
         </thead>
         
         
         
         <tfoot>
         <tr>
        <th></th>
         <th>NAME</th>
         <th>BRAND</th>
         <th>PRICE</th>
         <th>Qte.Available</th>
         <th></th>
         
         </tr>
         </tfoot>
         
         </table>
         
         
         </div>
         
         
         
         </div>
		</div>


	</div>


</div>