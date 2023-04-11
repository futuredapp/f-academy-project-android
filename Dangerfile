danger.import_dangerfile(github: "futuredapp/danger")

# Utils
def report_checkstyle_for_directory(directory_name)
  if Dir.exists?(directory_name)
    Dir.entries(directory_name).select {|f| f.end_with? '.xml'}.each {|f|
      report_checkstyle(directory_name + f)
    }
  end
end

def report_checkstyle(file_name)
  if File.file?(file_name)
    checkstyle_format.report file_name
  end
end

def report_android_lint(file_name)
  if File.file?(file_name)
    android_lint.report_file = file_name
    android_lint.filtering = true
    android_lint.skip_gradle_task = true
    android_lint.lint(inline_mode: true)
  end
end

def report_unit_tests_for_directory(directory_name)
  if Dir.exists?(directory_name)
    Dir.entries(directory_name).select {|f| f.end_with? '.xml'}.each {|f|
	  report_unit_tests(directory_name + f)
    }
  end
end

def report_unit_tests(file_name)
  if File.file?(file_name)
    junit.parse file_name
    junit.report
  end
end

# Setup checkstyle
checkstyle_format.base_path = Dir.pwd

# Detekt checkstyle
report_checkstyle 'build/reports/detekt/detekt.xml'

# Ktlint checkstyle
report_checkstyle_for_directory 'app/build/reports/ktlint/'
report_checkstyle 'build/reports/ktlint/ktlintKotlinScriptCheck.xml'

# Android lint
report_android_lint 'app/build/reports/lint-results-devEnterprise.xml'

# Unit tests report
report_unit_tests_for_directory 'app/build/test-results/testMockEnterpriseUnitTest/'
