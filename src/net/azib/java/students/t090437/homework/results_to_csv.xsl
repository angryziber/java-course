<?xml version="1.0" encoding='UTF-8'?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="text" indent="yes"/>
  
<xsl:param name="break" select="string('&#xD;')" />

<xsl:template match="/competition">
		<xsl:apply-templates/>
</xsl:template>

<xsl:template match="competitor">
<xsl:value-of select="position"/>,<xsl:value-of select="score"/>,<xsl:value-of select="@name"/>,<xsl:value-of select="@birthday"/>,<xsl:value-of select="@country"/>,<xsl:value-of select="sprint100m"/>,<xsl:value-of select="long_jump"/>,<xsl:value-of select="shot_put"/>,<xsl:value-of select="high_jump"/>,<xsl:value-of select="sprint400m"/>,<xsl:value-of select="hurdles"/>,<xsl:value-of select="discus"/>,<xsl:value-of select="pole_vault"/>,<xsl:value-of select="javelin_throw"/>,<xsl:value-of select="race1500m"/><xsl:value-of select="$break" />
</xsl:template>

</xsl:stylesheet>
