<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/DecathlonResults">
        <html>
            <body>
                <h2>Competition results</h2>
		 <xsl:for-each select="Competitor">
			<p><xsl:value-of select="Place" /> place: <xsl:value-of select="Points" /> points, <xsl:value-of select="Name" />, <xsl:value-of select="DateOfBirth" />, 
				<xsl:value-of select="Country" /><br/>
				Results: <xsl:value-of select="Results/Sprint100m" />, <xsl:value-of select="Results/LongJump" />, <xsl:value-of select="Results/ShotPut" />, 
				<xsl:value-of select="Results/HighJump" />, <xsl:value-of select="Results/Sprint400m" />, <xsl:value-of select="Results/Hurdles110m" />, 
				<xsl:value-of select="Results/DiscusThrow" />, <xsl:value-of select="Results/PoleVault" />, <xsl:value-of select="Results/JavelinThrow" />, 
				<xsl:value-of select="Results/Race1500m" />
			</p>
                    </xsl:for-each>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
