<?xml version="1.0"?> 
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"> 

    <xsl:template match="/athletes"> 
        <HTML> 
            <HEAD> 
                <TITLE> 
                    The Decathlon Results 
                </TITLE> 
            </HEAD> 
            <BODY> 
                <H1> 
                    The Decathlon Results 
                </H1> 
                <TABLE BORDER="2"> 
                    <TR> 
                        <TD>Place</TD>
                        <TD>Points</TD>
                        <TD>Name</TD> 
                        <TD>Date of birth</TD> 
                        <TD>Country</TD> 
                        <TD>100 m sprint (sec)</TD> 
                        <TD>Long jump (m)</TD> 
                        <TD>Shot put (m)</TD> 
                        <TD>High jump (m)</TD> 
                        <TD>400 m sprint (sec)</TD> 
                        <TD>110 m hurdles (sec)</TD> 
                        <TD>Discus throw (m)</TD> 
                        <TD>Pole vault (m)</TD> 
                        <TD>Javelin throw (m)</TD> 
                        <TD>1500 m race (sec)</TD> 
                    </TR> 
                    <xsl:apply-templates/> 
                </TABLE> 
            </BODY> 
        </HTML> 
    </xsl:template> 

    <xsl:template match="participant"> 
       <TR> 
          <TD><xsl:value-of select="place"/></TD> 
          <TD><xsl:value-of select="points"/></TD> 
          <TD><xsl:value-of select="name"/></TD> 
          <TD><xsl:value-of select="dob"/></TD> 
          <TD><xsl:value-of select="country"/></TD> 
          <TD><xsl:value-of select="race_100m"/></TD> 
          <TD><xsl:value-of select="long_jump"/></TD> 
          <TD><xsl:value-of select="shot_put"/></TD> 
          <TD><xsl:value-of select="high_jump"/></TD> 
          <TD><xsl:value-of select="race_400m"/></TD> 
          <TD><xsl:value-of select="hurdles_110m"/></TD> 
          <TD><xsl:value-of select="discus_throw"/></TD> 
          <TD><xsl:value-of select="pole_vault"/></TD> 
          <TD><xsl:value-of select="javelin_throw"/></TD> 
          <TD><xsl:value-of select="race_1500m"/></TD> 
       </TR> 
    </xsl:template> 

</xsl:stylesheet>
