/*
 *  Copyright 2010 Blue Lotus Software, LLC.
 *  Copyright 2010 John Yeary <jyeary@bluelotussoftware.com>.
 *  Copyright 2010 Allan O'Driscoll
 *
 * Dual Licensed MIT and GPL v.2 
 *
 * The MIT License
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 *
 *
 * The GNU General Public License (GPL) Version 2, June 1991
 * This program is free software; you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation; version 2 of the License.

 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License along with this program;
 * if not, write to the Free Software Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */
package BA.Server;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.eclipse.jetty.server.Request;

import BA.Solver.FormulaTester;
import BA.Solver.MacroManager;

/**
 * Reads an <code>application/octet-stream</code> and writes it to a file.
 * @author John Yeary <jyeary@bluelotussoftware.com>
 * @author Allan O'Driscoll
 * @version 1.0
 */
public class FileUpload extends HttpServlet {

    private static final long serialVersionUID = 6748857432950840322L; 

    /**
     * {@inheritDoc}
     * @param config
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @SuppressWarnings( "unchecked" )
    protected void doGet( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException
    {
    	
    	
        PrintWriter outp = resp.getWriter();

        PrintWriter writer = null;

        try {
            writer = resp.getWriter();
        } catch (IOException ex) {
            log(FileUpload.class.getName() + "has thrown an exception: " + ex.getMessage());
        }
        
        StringBuffer buff = new StringBuffer();

        File file1 = (File) req.getAttribute( "file" );

        if( file1 == null || !file1.exists() )
        {
            System.out.println( "File does not exist" );
        }
        else if( file1.isDirectory())
        {
        	System.out.println( "File is a directory" );
        }
        
        else
        {
        	File outputFile = new File( "/tmp/" + req.getParameter( "file" ) );
            file1.renameTo( outputFile );
            
            FileInputStream f = new FileInputStream(outputFile);

			// Here BufferedInputStream is added for fast reading.
	        BufferedInputStream bis = new BufferedInputStream(f);
	        DataInputStream dis = new DataInputStream(bis);
	        int i = 0;
	        String result = "";

	        
	        writer.write( "<html>" );
	        writer.write( "<head><script type='text/javascript'>" );
	        while (dis.available() != 0) {
	        	String current = dis.readLine();
	        	
	        	if (((String)req.getParameter("uploadType")).equals("equations")) {
	        		if (FormulaTester.testInput(current) == -1) {
	        			writer.write( "window.opener.addTabExt(\"" + current + "\" , \"" + req.getParameter( "file" ) + "\");" );
	        		}
	        	} else {	        			
	        		writer.write( "window.opener.addMacroExt(\"" + current + "\");" );
	        	}
	        	i++;
	        	
	        }
	     
	        writer.write( "this.close();</script></head>" );
	        writer.write( "</script></head>" );
	        writer.write( "<body>" );
	        writer.write( "</body>" );
	        writer.write( "</html>" );
	        
	        writer.flush();
	        writer.close();
	        
	        dis.close();
	        bis.close();
	        f.close();
	        outputFile.delete();
            
        }
    }

    protected void doPost( HttpServletRequest req, HttpServletResponse resp ) throws ServletException, IOException {
        doGet( req, resp );
    }
 
}


