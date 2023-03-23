import { useEffect } from 'react'

export default function App() {
	// User has switched back to the tab
	async function onFocus() {
		console.count('Next item copied')
		await navigator.clipboard.writeText('Próximo item copiado com sucesso.')
	}

	// User has switched away from the tab (AKA tab is hidden)
	function onBlur() {
		console.count('Tab out of focus')
	}

	useEffect(() => {
		window.addEventListener('focus', onFocus)
		window.addEventListener('blur', onBlur)
		// Calls onFocus when the window first loads
		onFocus()
		// Specify how to clean up after this effect:
		return () => {
			window.removeEventListener('focus', onFocus)
			window.removeEventListener('blur', onBlur)
		}
	}, [])

	return <></>
}
