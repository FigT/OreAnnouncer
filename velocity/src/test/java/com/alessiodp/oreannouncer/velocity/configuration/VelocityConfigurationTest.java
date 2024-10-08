package com.alessiodp.oreannouncer.velocity.configuration;

import com.alessiodp.core.common.addons.external.simpleyaml.configuration.file.YamlFile;
import com.alessiodp.core.common.configuration.ConfigOption;
import com.alessiodp.core.common.configuration.ConfigurationFile;
import com.alessiodp.core.common.logging.logger.ADPLogger;
import com.alessiodp.oreannouncer.velocity.configuration.data.VelocityConfigMain;
import com.alessiodp.oreannouncer.velocity.configuration.data.VelocityMessages;
import com.alessiodp.oreannouncer.common.OreAnnouncerPlugin;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.lang.reflect.Field;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class VelocityConfigurationTest {
	private static final OreAnnouncerPlugin mockPlugin = mock(OreAnnouncerPlugin.class);

	@BeforeAll
	public static void setUp() {
		ADPLogger testLogger = mock(ADPLogger.class);
		doAnswer((params) -> {
			//System.out.println((String) params.getArgument(0));
			return null;
		}).when(testLogger).info(anyString());
		doAnswer((params) -> {
			System.err.println((String) params.getArgument(0));
			return null;
		}).when(testLogger).error(anyString());
		when(mockPlugin.getLogger()).thenReturn(testLogger);

		when(mockPlugin.getResource(anyString())).thenAnswer((a) -> ClassLoader.getSystemResourceAsStream(a.getArgument(0)));
	}

	@Test
	public void testConfigMain(@TempDir Path tempDir) throws IllegalAccessException {
		VelocityConfigMain configMain = new VelocityConfigMain(mockPlugin);

		List<String> skipPaths = Arrays.asList(
				"alerts.sound",
				"alerts.coordinates",
				"blocks.bypass",
				"blocks.warn",
				"blocks.light-level",
				"blocks.height-level",
				"blocks.tnt",
				"stats.blacklist",
				"stats.advanced-count.default",
				"execute-commands"
		);

		testConfiguration(configMain, skipPaths, tempDir);
	}

	@Test
	public void testMessages(@TempDir Path tempDir) throws IllegalAccessException {
		VelocityMessages messages = new VelocityMessages(mockPlugin);

		List<String> skipPaths = Collections.singletonList(
				"alerts."
		);

		testConfiguration(messages, skipPaths, tempDir);
	}

	private void testConfiguration(ConfigurationFile configurationFile, List<String> skipPaths, Path tempDir) throws IllegalAccessException {
		Field[] fields = configurationFile.getClass().getFields();

		// Initialize YAML
		configurationFile.initializeConfiguration(tempDir);
		YamlFile yf = configurationFile.getConfiguration();

		// Check fields
		for (Field f : fields) {
			ConfigOption co = f.getAnnotation(ConfigOption.class);
			if (co != null && !skippablePath(co.path(), skipPaths)) {
				Object value = yf.get(co.path());
				assertNotNull(value, "The " + configurationFile.getClass().getSimpleName() + " path '" + co.path() + "' is null.");
				f.set(null, value);
			}
		}
	}

	private boolean skippablePath(String path, List<String> skipPaths) {
		for (String sp : skipPaths) {
			if (path.startsWith(sp))
				return true;
		}
		return false;
	}
}
