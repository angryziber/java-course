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
                <td>Origin</td>
                <td>Date Of Birth</td>
            	<td>100 m sprint</td>
    			<td>Long jump</td>
                <td>Shot put</td>
                <td>High jump</td>
                <td>400 m sprint</td>
                <td>110 m hurdles</td>
                <td>Discus throw</td>
                <td>Pole vault</td>
                <td>Javelin throw</td>
                <td>1500 m race</td> 
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
        <td><xsl:value-of select="event"/></td>
        <td><xsl:value-of select="event"/></td>
        <td><xsl:value-of select="event"/></td>
        <td><xsl:value-of select="event"/></td>
        <td><xsl:value-of select="event"/></td>
        <td><xsl:value-of select="event"/></td>
        <td><xsl:value-of select="event"/></td>
        <td><xsl:value-of select="event"/></td>
        <td><xsl:value-of select="event"/></td>
        <td><xsl:value-of select="event"/></td>
        <td><b><xsl:value-of select="total_result"/></b></td>
	</tr>
</xsl:template>

</xsl:stylesheet>
