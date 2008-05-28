<?xml version="1.0"?> 
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"> 

    <xsl:template match="/athletes"> 
        <HTML> 
            <HEAD> 
                <TITLE> 
                    Decathlon Results 
                </TITLE> 
            </HEAD> 
            <BODY> 
                <H1> 
                    The Decathlon Results 
                </H1> 
                <TABLE BORDER="2" ALLIGN="top"> 
                    <TR> 
                        <TD>Name</TD> 
                        <TD>Date of birth</TD> 
                        <TD>Country</TD> 
                        	<TD>100m sprint</TD> 
                        	<TD>Long jump</TD> 
                        	<TD>Shot put</TD> 
                        	<TD>High jump</TD> 
                        	<TD>400m sprint</TD> 
                       		<TD>110m hurdles</TD> 
                        	<TD>Discus throw</TD> 
                        	<TD>Pole vault</TD> 
                        	<TD>Javelin throw</TD> 
                        	<TD>1500m race</TD> 
						<TD>Points</TD>
						<TD>Place</TD>
                    </TR> 
                    <xsl:apply-templates/> 
                </TABLE> 
            </BODY> 
        </HTML> 
    </xsl:template> 

    <xsl:template match="athlete"> 
       <TR> 
          <TD><xsl:value-of select="name"/></TD> 
          <TD><xsl:value-of select="date"/></TD> 
          <TD><xsl:value-of select="country"/></TD> 
          <TD><xsl:value-of select="hundred_m_run"/></TD>
          <TD><xsl:value-of select="long_jump"/></TD>
          <TD><xsl:value-of select="shot_put"/></TD>
          <TD><xsl:value-of select="high_jump"/></TD>
          <TD><xsl:value-of select="fourh_m_run"/></TD>
          <TD><xsl:value-of select="hurdles"/></TD>
          <TD><xsl:value-of select="discus_throw"/></TD>
          <TD><xsl:value-of select="pole_vault"/></TD>
          <TD><xsl:value-of select="javelin_throw"/></TD>
          <TD><xsl:value-of select="running"/></TD> 
	  	  <TD><xsl:value-of select="points"/></TD> 
	      <TD><xsl:value-of select="place"/></TD> 
       </TR> 
    </xsl:template> 

</xsl:stylesheet>
