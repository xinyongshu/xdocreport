/**
 * Copyright (C) 2011 The XDocReport Team <xdocreport@googlegroups.com>
 *
 * All rights reserved.
 *
 * Permission is hereby granted, free  of charge, to any person obtaining
 * a  copy  of this  software  and  associated  documentation files  (the
 * "Software"), to  deal in  the Software without  restriction, including
 * without limitation  the rights to  use, copy, modify,  merge, publish,
 * distribute,  sublicense, and/or sell  copies of  the Software,  and to
 * permit persons to whom the Software  is furnished to do so, subject to
 * the following conditions:
 *
 * The  above  copyright  notice  and  this permission  notice  shall  be
 * included in all copies or substantial portions of the Software.
 *
 * THE  SOFTWARE IS  PROVIDED  "AS  IS", WITHOUT  WARRANTY  OF ANY  KIND,
 * EXPRESS OR  IMPLIED, INCLUDING  BUT NOT LIMITED  TO THE  WARRANTIES OF
 * MERCHANTABILITY,    FITNESS    FOR    A   PARTICULAR    PURPOSE    AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE,  ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package org.apache.poi.xwpf.converter.pdf;

import org.apache.poi.xwpf.converter.core.Options;

import fr.opensagres.xdocreport.itext.extension.font.IFontProvider;

/**
 * Pdf options to customize the DOCX->PDF converter.
 */
public class PdfOptions
    extends Options
{

    private static final PdfOptions DEFAULT = new PdfOptions();

    private String fontEncoding;

    private IFontProvider fontProvider;

    private PdfOptions()
    {
        this.fontEncoding = ITextFontRegistry.getRegistry().getSystemEncoding();
        this.fontProvider = ITextFontRegistry.getRegistry();
    }

    /**
     * Create an instance of Pdf options.
     * 
     * @return
     */
    public static PdfOptions create()
    {
        return new PdfOptions();
    }

    /**
     * Returns the font encoding.
     * 
     * @return
     */
    public String getFontEncoding()
    {
        return fontEncoding;
    }

    /**
     * Set font encoding to use when retrieving fonts. The default value is underlying operating system encoding
     * 
     * @param fontEncoding font encoding to use
     * @return this instance
     */
    public PdfOptions fontEncoding( String fontEncoding )
    {
        this.fontEncoding = fontEncoding;
        return this;
    }

    /**
     * Set the font provider.
     * 
     * @param fontProvider
     * @return
     */
    public PdfOptions fontProvider( IFontProvider fontProvider )
    {
        this.fontProvider = fontProvider;
        return this;
    }

    /**
     * Returns the font provider.
     * 
     * @return
     */
    public IFontProvider getFontProvider()
    {
        return fontProvider;
    }

    /**
     * Returns the default Pdf Options.
     * 
     * @return
     */
    public static PdfOptions getDefault()
    {
        return DEFAULT;
    }
}
