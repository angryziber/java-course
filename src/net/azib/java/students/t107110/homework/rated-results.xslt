<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns="http://www.w3.org/1999/xhtml"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes"
	            doctype-public="-//W3C//DTD XHTML 1.1//EN"
	            doctype-system="http://www.w3.org/TR/xhtml11/DTD/xhtml11.dtd"/>
	<xsl:template match="/rated-results">
		<html>
			<head>
				<title>Decathlon Competition</title>
				<style type="text/css">
					body {
						font-family: sans-serif;
						font-size: smaller;
						/*font-weight: lighter;*/
					}

					table {
						border-collapse: collapse;
					}

					td, th {
						border-bottom: #999 solid 1px;
						border-top: #999 solid 1px;
						padding: 3px;
					}

					td {
						vertical-align: baseline;
					}

					th {
						vertical-align: middle;
					}

					td.left {
						text-align: left;
					}

					td.center {
						text-align: center;
					}

					td.right {
						text-align: right;
					}

					.odd td {
						background-color: #eee;
					}

					.even td {
						background-color: #ddd;
					}

					.heading th {
						background-color: #ccc;
					}

					.title th {
						background-color: #eee;
						font-size: larger;
					}
				</style>
			</head>
			<body>
				<table>
					<tr class="title">
						<th colspan="15">
							<div>Decathlon Competition</div>
						</th>
					</tr>
					<tr class="heading">
						<th>
							<div>place</div>
						</th>
						<th>
							<div>points</div>
						</th>
						<th>
							<div>athlete</div>
						</th>
						<th>
							<div>birthday</div>
						</th>
						<th>
							<div>country</div>
						</th>
						<th>
							<div>100m</div>
						</th>
						<th>
							<div>long</div>
							<div>jump</div>
						</th>
						<th>
							<div>shot</div>
							<div>put</div>
						</th>
						<th>
							<div>high</div>
							<div>jump</div>
						</th>
						<th>
							<div>400m</div>
						</th>
						<th>
							<div>110m</div>
							<div>hurdles</div>
						</th>
						<th>
							<div>discus</div>
							<div>throw</div>
						</th>
						<th>
							<div>pole</div>
							<div>vault</div>
						</th>
						<th>
							<div>javelin</div>
							<div>throw</div>
						</th>
						<th>
							<div>1500m</div>
						</th>
					</tr>
					<xsl:for-each select="result">
						<tr>
							<xsl:attribute name="class">
								<xsl:choose>
									<xsl:when test="position() mod 2 = 1">odd</xsl:when>
									<xsl:otherwise>even</xsl:otherwise>
								</xsl:choose>
							</xsl:attribute>
							<td class="right">
								<xsl:value-of select="@place"/>
							</td>
							<td class="right">
								<xsl:value-of select="@points"/>
							</td>
							<td class="left">
								<xsl:value-of select="@athlete"/>
							</td>
							<td class="left">
								<xsl:value-of select="@birthday"/>
							</td>
							<td class="center">
								<xsl:value-of select="@country"/>
							</td>
							<xsl:for-each select="event">
								<td class="right">
									<xsl:value-of select="@result"/>
									<xsl:if test="@type = 'distance'">m</xsl:if>
								</td>
							</xsl:for-each>
						</tr>
					</xsl:for-each>
				</table>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>