<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="text" indent="yes" />

	<!-- Athlete transformation from XML to text -->

	<xsl:template match="/">
	-=[Athletes]=-<xsl:apply-templates />
	</xsl:template>

	<xsl:template match="athlete">
	Name: <xsl:value-of select="name" />
	Country: <xsl:value-of select="country" />
	Birth date: <xsl:value-of select="birthdate" />
	Total score: <xsl:value-of select="score" />
		<xsl:apply-templates select="results/result" />
	</xsl:template>

	<xsl:template match="result">
		* <xsl:value-of select="event" /> - <xsl:value-of select="performance" />
	</xsl:template>

</xsl:stylesheet>