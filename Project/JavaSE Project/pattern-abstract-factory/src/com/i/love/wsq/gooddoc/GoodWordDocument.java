package com.i.love.wsq.gooddoc;

import com.i.love.wsq.service.WordDocument;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author baitao05
 */
public class GoodWordDocument implements WordDocument {
    private String md;
    @Override
    public void save(Path path) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>\n"
                + "<?mso-application progid=\"Word.Document\"?>\n"
                + "<w:wordDocument xmlns:aml=\"http://schemas.microsoft.com/aml/2001/core\" xmlns:o=\"urn:schemas-microsoft-com:office:office\" xmlns:v=\"urn:schemas-microsoft-com:vml\" xmlns:w=\"http://schemas.microsoft.com/office/word/2003/wordml\" xmlns:wx=\"http://schemas.microsoft.com/office/word/2003/auxHint\" xmlns:wsp=\"http://schemas.microsoft.com/office/word/2003/wordml/sp2\" w:macrosPresent=\"no\" w:embeddedObjPresent=\"no\" w:ocxPresent=\"no\" xml:space=\"preserve\">\n"
                + "<w:fonts><w:font w:name=\"Times New Roman\"><w:panose-1 w:val=\"02020603050405020304\"/><w:charset w:val=\"00\"/><w:family w:val=\"Roman\"/><w:pitch w:val=\"variable\"/><w:sig w:usb-0=\"E0002EFF\" w:usb-1=\"C000785B\" w:usb-2=\"00000009\" w:usb-3=\"00000000\" w:csb-0=\"000001FF\" w:csb-1=\"00000000\"/></w:font></w:fonts>\n"
                + "<w:styles><w:style w:type=\"paragraph\" w:default=\"on\" w:styleId=\"a\"><w:name w:val=\"Normal\"/><w:rPr><w:kern w:val=\"2\"/><w:sz w:val=\"21\"/><w:sz-cs w:val=\"22\"/></w:rPr></w:style><w:style w:type=\"paragraph\" w:styleId=\"1\"><w:name w:val=\"heading 1\"/><w:basedOn w:val=\"a\"/><w:rsid w:val=\"00DC0742\"/><w:rPr><w:b/><w:b-cs/><w:kern w:val=\"44\"/><w:sz w:val=\"44\"/><w:sz-cs w:val=\"44\"/></w:rPr></w:style></w:styles>\n"
                + "<w:docPr><wsp:rsids><wsp:rsidRoot wsp:val=\"00DC0742\"/><wsp:rsid wsp:val=\"0003739C\"/><wsp:rsid wsp:val=\"00DC0742\"/><wsp:rsid wsp:val=\"00EB4B25\"/></wsp:rsids></w:docPr>\n"
                + "<w:body><wx:sect><wx:sub-section>");
        BufferedReader reader = new BufferedReader(new StringReader(md));
        reader.lines().forEach(s -> {
            if (s.startsWith("#")) {
                sb.append(String.format(
                        "<w:p wsp:rsidR=\"0003739C\" wsp:rsidRDefault=\"00DC0742\" wsp:rsidP=\"00DC0742\"><w:pPr><w:pStyle w:val=\"1\"/></w:pPr><w:r><w:t>%s</w:t></w:r></w:p>",
                        s.substring(1)));
            } else {
                sb.append(String.format(
                        "<w:p wsp:rsidR=\"00DC0742\" wsp:rsidRDefault=\"00DC0742\"><w:r><w:t>%s</w:t></w:r></w:p>", s));
            }
        });
        sb.append("</wx:sub-section></wx:sect></w:body></w:wordDocument>");
        String content = sb.toString();
        Files.write(path, content.getBytes("UTF-8"));
    }
}
