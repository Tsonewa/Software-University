function editElement(reference, match, replacer) {
  const content = reference.textContent;
  const matcher = new RegExp(match, 'g');
  const result = content.replace(matcher, replacer);
  reference.textContent = result;
}