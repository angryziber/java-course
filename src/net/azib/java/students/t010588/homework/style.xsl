<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/decathlon">
        <h2 align="left">Results</h2>
        <table border="1" cellpadding="5">
            <tr align="left">
                <th>Place</th>
                <th>Name</th>
                <th>Total score</th>
                <th>Birthday</th>
                <th>Country</th>
                <th>Event 1</th>
                <th>Event 2</th>
                <th>Event 3</th>
                <th>Event 4</th>
                <th>Event 5</th>
                <th>Event 6</th>
                <th>Event 7</th>
                <th>Event 8</th>
                <th>Event 9</th>
                <th>Event 10</th>
            </tr>
			<xsl:for-each select="//athlete">
				<tr>
				    <td>
					   <xsl:value-of select="@place"/>
					</td>
					<td>
					   <xsl:value-of select="@name"/>
					</td>
					<td>
                        <xsl:value-of select="@score"/>
                    </td>
                    <td>
                        <xsl:value-of select="@birthDay"/>
                    </td>
                    <td>
                        <xsl:value-of select="@country"/>
                    </td>
                    <xsl:for-each select=".//result">
                        <td>
	                        <xsl:value-of select="@value"/>
	                    </td>
                    </xsl:for-each>
				</tr>
			</xsl:for-each>
		</table>
	</xsl:template>
</xsl:stylesheet>