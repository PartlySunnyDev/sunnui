package me.partlysunny.sunnui.parser;

import me.partlysunny.sunnui.type.GuiType;

import java.io.File;
import java.io.InputStream;

public interface GuiFileParser {

    GuiType<?> parse(File file);

    GuiType<?> parse(InputStream stream);

    GuiType<?> parse(String pathTo);

}
