<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html"/>

<xsl:template match="/">
	<html>
	<body>
		<xsl:for-each select="//book">
			<xsl:apply-templates select="."/>
		</xsl:for-each>
	</body>
	</html>
</xsl:template>

<xsl:template match="book">
	<!-- TODO -->
</xsl:template>

</xsl:stylesheet>
