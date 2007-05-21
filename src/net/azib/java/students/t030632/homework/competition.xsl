<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet
    version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <!--****************************************************************
    ** "/" template
    ************************************************************* -->
    <xsl:template match="/competition">
        <html>
            <head>
                <title>Decathlon Competition Results</title>
            </head>
            <body>
                <h1>Decathlon Competition Results</h1>
                <hr/>
                <table>
                    <tr>
                        <td align="right" WIDTH="50">
                            <b>Place</b>
                        </td>
                        <td align="right" WIDTH="100">
                            <b>Total</b>
                        </td>
                        <td align="right" WIDTH="80">
                            <b>Competitor</b>
                        </td>
                        <td align="right" WIDTH="100">
                            <b>Birthday</b>
                        </td>
                        <td align="right" WIDTH="100">
                            <b>Country</b>
                        </td>
                        <td align="right" WIDTH="80">
                            <b>100 m</b>
                        </td>
                        <td align="right" WIDTH="80">
                            <b>Long Jump</b>
                        </td>
                        <td align="right" WIDTH="80">
                            <b>Shot Put</b>
                        </td>
                        <td align="right" WIDTH="80">
                            <b>High Jump</b>
                        </td>
                        <td align="right" WIDTH="80">
                            <b>400 m</b>
                        </td>
                        <td align="right" WIDTH="80">
                            <b>110m Hurdles</b>
                        </td>
                        <td align="right" WIDTH="80">
                            <b>Discus Throw</b>
                        </td>
                        <td align="right" WIDTH="80">
                            <b>Pole Vault</b>
                        </td>
                        <td align="right" WIDTH="80">
                            <b>Javelin Throw</b>
                        </td>
                        <td align="right" WIDTH="80">
                            <b>1500 m</b>
                        </td>
                        
                    </tr>
                    <xsl:apply-templates select="competitor"/>
                </table>
            </body>
        </html>
    </xsl:template>
    <!--***************************************************************
    ** "competitor" template
    *********************************************** *************-->
    <xsl:template match="competitor">
        <tr>
            <!--<td VALIGN="TOP" align="right" WIDTH="50">
                <xsl:value-of select="@id"/>
            </td>
            -->
            <td WIDTH="80">
            	<div align="right">
                	<xsl:value-of select="place"/>
                	<br/>
            	</div>
            </td>
            <td WIDTH="80">
            	<div align="right">
                	<xsl:value-of select="Total_Points"/>
                	<br/>
                </div>
            </td>
            <td WIDTH="80">
	            <div align="right">
    	            <xsl:value-of select="competitors_name"/>
        	        <br/>
                </div>
            </td>
            <td WIDTH="80">
            	<div align="right">
	                <xsl:value-of select="competitors_date_of_birth"/>
    	            <br/>
                </div>
            </td>
            <td WIDTH="80">
                <div align="right">
                	<xsl:value-of select="competitors_Country"/>
                	<br/>
                </div>
            </td>
            <xsl:apply-templates select="events"/>
            <!--<td align="right" WIDTH="100">
                <b>
                    <br/>
                    <xsl:value-of select="total"/>
                </b>
            </td>
        --></tr>
    </xsl:template>
    <!--***************************************************************
    ** "events" template
    *********************************************** *************-->
    <xsl:template match="events">
        <xsl:for-each select="event">
            <td WIDTH="80">
                <div align="right">
                    <xsl:value-of select="result"/>
                </div>
            </td>
        </xsl:for-each>
    </xsl:template>
</xsl:stylesheet>