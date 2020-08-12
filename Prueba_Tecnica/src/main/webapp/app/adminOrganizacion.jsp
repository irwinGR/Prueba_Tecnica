<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
		<script type="text/javascript" src="${pageContext.request.contextPath}/scripts/organizaciones/adminOrganizaciones.js"></script>

		<section id="widget-grid">
			<div id="divActividad" class="row">
				<article class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<div class="jarviswidget" id="jwActividad"
						data-widget-togglebutton="false" data-widget-deletebutton="false"
						data-widget-editbutton="false" data-widget-sortable="false">
						<header>
							<h2><b>Administración de Organizaciones</b></h2>
						<h2 id="adminActividad"></h2>
						</header>
						<div>
							<div class="widget-body-toolbar">
									<button id="btnPlus" type="button"
										class="btn btn-primary btn-sm">
										<i class="fa fa-user-plus"></i> Crear
									</button>

									<button id="btnEdit" type="button"
										class="btn btn-warning btn-sm">
										<i class="fa fa-pencil"></i> Ver informacion
									</button>
							</div>
							<div class="widget-body">
								<table id="dtOrganizacion"
									class="table table-striped table-bordered table-hover DTTT_selectable"
									cellspacing="0" width="100%" cellspacing="0" width="100%" onkeydown="return soloLetras(event)">
									<thead>
										
										<tr>
											<th data-hide=" phone">IDExterno</th>
											<th data-hide="phone,tablet,desktop">Nombre</th>
											
										</tr>
									</thead>
								</table>
							</div>
						</div>
					</div>
				</article>
			</div>

			<div id="divCrear" class="row" style="display: none">
				<article class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
					<jsp:include page="organizacionAdd.jsp"></jsp:include>
				</article>
			</div>
		</section>
