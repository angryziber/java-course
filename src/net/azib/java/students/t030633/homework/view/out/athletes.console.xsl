<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="text" />

	<!-- Athlete transformation from XML to text -->

	<xsl:template match="/">

		<xsl:text>-=[Athletes]=-</xsl:text>
		<xsl:apply-templates />

	</xsl:template>

	<xsl:template match="athlete">

		<xsl:text>&#xa;</xsl:text>
		<xsl:text>#</xsl:text>
		<xsl:value-of select="place" />
		<xsl:text> - </xsl:text>
		<xsl:value-of select="name" />
		<xsl:text>&#xa;Country: </xsl:text>
		<xsl:value-of select="country" />
		<xsl:apply-templates select="birthdate" />
		<xsl:text>&#xa;Total score: </xsl:text>
		<xsl:value-of select="score" />
		<xsl:apply-templates select="results/result" />

	</xsl:template>

	<xsl:template match="result">
		<xsl:text>&#xa;  </xsl:text>
		<xsl:value-of select="event" />
		<xsl:text> -- </xsl:text>
		<xsl:value-of select="performance" />
	</xsl:template>
	
	
	<xsl:template match="birthdate">
		<xsl:text>&#xa;Birth date: </xsl:text>
		<!-- Select local date format -->
		<xsl:value-of select="@local" />
	</xsl:template>

</xsl:stylesheet>