<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:fn="http://www.w3.org/2005/02/xpath-functions"
	xmlns:date="http://exslt.org/dates-and-times">
	<xsl:output method="text" />

	<!-- Athlete transformation from XML to text -->

	<xsl:template match="/">

		<!-- parse every athlete -->
		<xsl:for-each select="//athlete">

			<xsl:value-of select="place" />
			<xsl:text>,</xsl:text>
			<xsl:value-of select="score" />
			<xsl:text>,"</xsl:text>
			<xsl:value-of select="name" />
			<xsl:text>",</xsl:text>

			<!-- reformat xsd "date" format -->
			<xsl:for-each select="birthdate">
				<xsl:value-of select="substring(string(.), 9, 2)" />
				<xsl:text>.</xsl:text>
				<xsl:value-of select="substring(string(.), 6, 2)" />
				<xsl:text>.</xsl:text>
				<xsl:value-of select="substring(string(.), 1, 4)" />
				<xsl:text>,</xsl:text>
			</xsl:for-each>
			
			<xsl:value-of select="country" />
			<xsl:text>,</xsl:text>
			
			<xsl:for-each select="results//performance">
				<xsl:value-of select="." />
				<xsl:if test="position() != last()">,</xsl:if>
			</xsl:for-each>

			<!-- new line -->
			<xsl:text>&#xa;</xsl:text>

		</xsl:for-each>

	</xsl:template>

	<xsl:template name="dateformat">

	</xsl:template>

</xsl:stylesheet>