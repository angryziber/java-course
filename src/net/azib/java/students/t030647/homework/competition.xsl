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
                <h2>Decathlon Competition Results</h2>
                <hr/>
                <table border="1"  cellspacing="0" cellpadding="0">
                    <tr align="center">
                        <td align="center" WIDTH="25">
                            <b>Place</b>
                        </td>
                        <td align="center" WIDTH="80">
                            <b>Total</b>
                        </td>
                        <td align="center" WIDTH="120">
                            <b>Competitor</b>
                        </td>
                        <td align="center" WIDTH="100">
                            <b>Birthday</b>
                        </td>
                        <td align="center" WIDTH="80">
                            <b>Country</b>
                        </td>
                        <td align="center" WIDTH="80">
                            <b>100 m</b>
                        </td>
                        <td align="center" WIDTH="80">
                            <b>Long Jump</b>
                        </td>
                        <td align="center" WIDTH="80">
                            <b>Shot Put</b>
                        </td>
                        <td align="center" WIDTH="80">
                            <b>High Jump</b>
                        </td>
                        <td align="center" WIDTH="80">
                            <b>400 m</b>
                        </td>
                        <td align="center" WIDTH="80">
                            <b>110m Hurdles</b>
                        </td>
                        <td align="center" WIDTH="80">
                            <b>Discus Throw</b>
                        </td>
                        <td align="center" WIDTH="80">
                            <b>Pole Vault</b>
                        </td>
                        <td align="center" WIDTH="80">
                            <b>Javelin Throw</b>
                        </td>
                        <td align="center" WIDTH="80">
                            <b>1500 m</b>
                        </td>
                        
                    </tr>
                    <xsl:apply-templates select="Participant"/>
                </table>
            </body>
        </html>
    </xsl:template>
    <!--***************************************************************
    ** "competitor" template
    *********************************************** *************-->
    <xsl:template match="Participant">
        <tr align="center">
            <!--<td VALIGN="TOP" align="center" WIDTH="50">
                <xsl:value-of select="@id"/>
            </td>
            -->
            <td WIDTH="80">
                <xsl:value-of select="Place"/>
                <br/>
            </td>
            <td WIDTH="80">
                <xsl:value-of select="Total_Points"/>
                <br/>
            </td>
            <td WIDTH="80">
                <xsl:value-of select="Name"/>
                <br/>
            </td>
            <td WIDTH="80">
                <xsl:value-of select="Birthday"/>
                <br/>
            </td>
            <td WIDTH="80">
                <xsl:value-of select="Country"/>
                <br/>
            </td>
            <xsl:apply-templates select="Events"/>
            <!--<td align="center" WIDTH="100">
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
    <xsl:template match="Events">
        <xsl:for-each select="event">
            <td WIDTH="80">
                <div align="center">
                    <xsl:value-of select="result"/>
                </div>
            </td>
        </xsl:for-each>
    </xsl:template>
</xsl:stylesheet>