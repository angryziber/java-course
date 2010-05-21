<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="html" indent="yes"/>

<xsl:template match="/athletes">
	<html>
	<body>
    	<table border="2">
        	<tr>
            	<td>Place</td>
                <td>Name</td>
                <td>Country</td>
                <td>DOB</td>
                <td>event1</td>
                <td>event2</td>
                <td>event3</td>
                <td>event4</td>
                <td>event5</td>
                <td>event6</td>
                <td>event7</td>
                <td>event8</td>
                <td>event9</td>
                <td>event10</td>
                <td>Total Result</td>
            </tr>
		<xsl:apply-templates/>
		</table>
    </body>
	</html>
</xsl:template>

<xsl:template match="athlete">
	<tr>
		<td><xsl:value-of select="@place"/></td>
        <td><xsl:value-of select="@name"/></td>
        <td><xsl:value-of select="@origin"/></td>
        <td><xsl:value-of select="@dob"/></td>
        <td><xsl:value-of select="event0"/></td>
        <td><xsl:value-of select="event1"/></td>
        <td><xsl:value-of select="event2"/></td>
        <td><xsl:value-of select="event3"/></td>
        <td><xsl:value-of select="event4"/></td>
        <td><xsl:value-of select="event5"/></td>
        <td><xsl:value-of select="event6"/></td>
        <td><xsl:value-of select="event7"/></td>
        <td><xsl:value-of select="event8"/></td>
        <td><xsl:value-of select="event9"/></td>
        <td><b><xsl:value-of select="total_result"/></b></td>
	</tr>
</xsl:template>

</xsl:stylesheet>
